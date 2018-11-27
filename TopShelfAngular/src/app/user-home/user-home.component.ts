import { Component, OnInit } from '@angular/core';
import { RecipesService } from '../recipes.service';
import { Router } from '@angular/router';
import { IRecipes } from '../irecipes';
import { Recipe } from '../models/recipe';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  recipe: IRecipes = {} as IRecipes;

  constructor(private recipesService: RecipesService, private router: Router) { 
    this.searchFeatureRecipe();
  }

  ngOnInit() {
  }

  searchFeatureRecipe() {
    let index: number = 6;
    let searchQuery: string = "kangaroo"

   this.recipesService.getFeatureRecipes(searchQuery, index).subscribe(apiRecipe => {
      this.recipe = apiRecipe; 
      console.log(this.recipe);
   })
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
