import { Component, OnInit } from '@angular/core';
import { Fridge_Grocery_Service } from '../fridge-grocery.service';
import { User } from '../models/user';
import { Fridge } from '../models/fridge';
import { RecipesService } from '../recipes.service';
import { IRecipes } from '../irecipes';
import { Subscription } from 'rxjs';
import { Recipe } from '../models/recipe';
import { Router } from '@angular/router';
import * as parsing from '../parser/parse'
import { Ingredient } from '../models/ingredient';

@Component({
  selector: 'app-possible-recipes',
  templateUrl: './possible-recipes.component.html',
  styleUrls: ['./possible-recipes.component.css']
})
export class PossibleRecipesComponent implements OnInit {

  user: User;
  myFridge: Fridge;
  displayedColumns: string[];

  fridgeSource;
  fridgeSelection;

  recipes: IRecipes = {} as IRecipes;
  searchExecuted = false;
  subscription: Subscription;
  noResultList: boolean = false;
  isHover: boolean[] = [false, false, false, false, false, false];
  searchIndex: number = 0;
  minSearchIndex: boolean = true;
  maxSearchIndex: boolean = true; 
    
  constructor(private fgService: Fridge_Grocery_Service, private recipesService: RecipesService, private router: Router) {
    this.user = this.fgService.user;
    this.myFridge = this.fgService.myFridge;

    this.displayedColumns = ['select', 'ingredient'];

    this.fridgeSource = this.fgService.fridgeSource;
    this.fridgeSelection = this.fgService.fridgeSelection;

  }

  ngOnInit() {
  }

  searchForRecipe(pageIndex: number) {
    let fridgeItems: Array<string> = [];

    for(let selection of this.fridgeSelection.selected){
      fridgeItems.push(selection.ingredient);
      console.log(fridgeItems);
    }

    this.searchExecuted = true;
    let searchBar = (<HTMLInputElement>document.getElementById('searchQuery')).value;
    let searchQuery: string = (searchBar + ',' + fridgeItems)

    if(pageIndex == 0){
      this.minSearchIndex = true;
    }

    this.noResultList = false;
    pageIndex = this.searchIndex; 

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

  isAllSelectedInFridge() {
    this.fgService.isAllSelectedInFridge();
  }

  masterToggleFridge() {
    this.fgService.masterToggleFridge();
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
