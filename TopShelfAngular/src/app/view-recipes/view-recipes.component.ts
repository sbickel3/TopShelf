import { Component, OnInit } from '@angular/core';
import { RecipesService } from '../recipes.service';
import { IRecipes } from '../irecipes';
import { Subscription } from 'rxjs';
import { Recipe } from '../models/recipe';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-recipes',
  templateUrl: './view-recipes.component.html',
  styleUrls: ['./view-recipes.component.css']
})
export class ViewRecipesComponent implements OnInit {

  recipes: IRecipes = {} as IRecipes;
  searchExecuted = false;
  subscription: Subscription;
  noResultList: boolean = false;
  isHover: boolean[] = [false, false, false, false, false, false];
  searchIndex: number = 0;
  minSearchIndex: boolean = true;
  maxSearchIndex: boolean = true; 

  constructor(private recipesService: RecipesService, private router:Router) { }

  ngOnInit() {
  }

  searchForRecipe(pageIndex: number) {
    if(pageIndex == 0){
      this.minSearchIndex = true;
    }

    this.noResultList = false;
    pageIndex = this.searchIndex; 
    
    let searchQuery = (<HTMLInputElement>document.getElementById('searchQuery')).value;
    if(searchQuery){
      this.searchExecuted = true;
      this.subscription = this.recipesService.getRecipes(searchQuery, pageIndex).subscribe(apiRecipes => {
        this.recipes = apiRecipes;
        
        if(this.recipes.hits.length == 0){
          this.noResultList = true;
        }
        else if(this.recipes.hits.length < 6){
          this.maxSearchIndex = true;
        }
        else{
          this.maxSearchIndex = false; 
          this.minSearchIndex = false; 
          if(pageIndex == 0){
            this.minSearchIndex = true;
          }
        }
      });
    }
  }

  nextPreviousQuery(){
    this.searchIndex--;
    this.maxSearchIndex = false; 
    if(this.searchIndex < 0){
      this.searchIndex == 0;
      this.minSearchIndex = true;
    } 
    else{
      this.searchForRecipe(this.searchIndex);
    } 
  }

  nextSearchQuery(){
    this.searchIndex++; 
    this.minSearchIndex = false; 

    this.searchForRecipe(this.searchIndex);
  }

  editRecipe(myRecipe: Recipe){

    localStorage.setItem('recipe', JSON.stringify(myRecipe));
    
    this.router.navigate(['single-recipe']);

  }

  viewRecipe(recipeName: any, recipeInstructions: any, recipePhoto: any, recipeIngredients: string[]){

    let myRecipe: Recipe = {} as Recipe;
    myRecipe.name = recipeName;
    myRecipe.instruction = recipeInstructions;
    myRecipe.photo = recipePhoto;
    myRecipe.ingredientList = [];

    // for(let ing of recipeIngredients){
    //   myRecipe.ingredientList.push(parsing.parse(ing));
    // }

    localStorage.setItem('recipe', JSON.stringify(myRecipe));
    localStorage.setItem('recipe-ingredient', JSON.stringify(recipeIngredients));
    
    this.router.navigate(['single-recipe']);

  }

}