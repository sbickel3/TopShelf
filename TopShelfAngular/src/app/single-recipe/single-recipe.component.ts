import { Component, OnInit } from '@angular/core';
import { Ingredient } from '../models/ingredient';
import { SelectionModel } from '@angular/cdk/collections';
import { MatTableDataSource } from '@angular/material';
import { ChefRecipesService } from '../chef-recipes.service';
import { Router } from '@angular/router';
import { Recipe } from '../models/recipe';

@Component({
  selector: 'app-single-recipe',
  templateUrl: './single-recipe.component.html',
  styleUrls: ['./single-recipe.component.css']
})
export class SingleRecipeComponent implements OnInit {

  chosenRecipe: Recipe;
  newRecipeIngredient: String[];
  // displayedColumns: string[];
  // recipeIngredientSource;
  // recipeIngredientSelection;

  constructor(private chefRecipeService: ChefRecipesService, private router: Router) {
    this.chosenRecipe = JSON.parse(localStorage.getItem('recipe'));
    this.newRecipeIngredient = JSON.parse(localStorage.getItem('recipe-ingredient'));

    // this.displayedColumns = ['select', 'quantity', 'unit', 'ingredient'];
    // this.recipeIngredientSource = new MatTableDataSource<Ingredient>(this.chosenRecipe.ingredientList);
    // this.recipeIngredientSelection = new SelectionModel<Ingredient>(true, []);
  }

  ngOnInit() {
  }

  // /** Whether the number of selected elements matches the total number of rows. */
  // isAllSelectedInIngredientTable() {
  //   const numSelected = this.recipeIngredientSelection.selected.length;
  //   const numRows = this.recipeIngredientSource.data.length;
  //   return numSelected === numRows;
  // }

  // /** Selects all rows if they are not all selected; otherwise clear selection. */
  // masterToggleIngredientTable() {
  //   this.isAllSelectedInIngredientTable() ?
  //     this.recipeIngredientSelection.clear() :
  //     this.recipeIngredientSource.data.forEach(row => this.recipeIngredientSelection.select(row));
  // }

}
