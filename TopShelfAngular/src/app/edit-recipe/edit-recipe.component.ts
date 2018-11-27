import { Component, OnInit } from '@angular/core';
import { ChefRecipesService } from '../chef-recipes.service';
import { Router } from '@angular/router';
import { Recipe } from '../models/recipe';
import { Ingredient } from '../models/ingredient';
import { SelectionModel } from '@angular/cdk/collections';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-edit-recipe',
  templateUrl: './edit-recipe.component.html',
  styleUrls: ['./edit-recipe.component.css']
})
export class EditRecipeComponent implements OnInit {

  updatedRecipe: Recipe;
  newRecipeIngredient = new Ingredient();
  displayedColumns: string[];
  recipeIngredientSource;
  recipeIngredientSelection;

  constructor(private chefRecipeService: ChefRecipesService, private router: Router) {
    this.updatedRecipe = JSON.parse(localStorage.getItem('recipe'));
    this.displayedColumns = ['select', 'quantity', 'unit', 'ingredient'];
    this.recipeIngredientSource = new MatTableDataSource<Ingredient>(this.updatedRecipe.ingredientList);
    this.recipeIngredientSelection = new SelectionModel<Ingredient>(true, []);
  }

  ngOnInit() {
  }

  updateRecipe() {
    this.chefRecipeService.updateChefRecipe(this.updatedRecipe).subscribe(recipe => {
      this.router.navigate(['chef-recipes']);
    })
  }

  deleteRecipe() {
    this.chefRecipeService.deleteChefRecipe(this.updatedRecipe).subscribe(deletedRecipe => {
      this.router.navigate(['chef-recipes']);
    });
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelectedInIngredientTable() {
    const numSelected = this.recipeIngredientSelection.selected.length;
    const numRows = this.recipeIngredientSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggleIngredientTable() {
    this.isAllSelectedInIngredientTable() ?
      this.recipeIngredientSelection.clear() :
      this.recipeIngredientSource.data.forEach(row => this.recipeIngredientSelection.select(row));
  }

  removeFromIngredientTable() {
    this.recipeIngredientSelection.selected.forEach(item => {
      let index: number = this.recipeIngredientSource.data.findIndex(d => d === item);
      this.recipeIngredientSource.data.splice(index, 1);
      this.recipeIngredientSource = new MatTableDataSource<Ingredient>(this.recipeIngredientSource.data);
    });
    this.recipeIngredientSelection = new SelectionModel<Ingredient>(true, []);
    console.log(this.recipeIngredientSource.data);
  }

  addToRecipeIngredients() {
    let myIngArr: Ingredient[];
    myIngArr = this.recipeIngredientSource.data;
    if (this.newRecipeIngredient.quantity && this.newRecipeIngredient.unit && this.newRecipeIngredient.ingredient) {
      if (Number(this.newRecipeIngredient.quantity) >= 0 && Number(this.newRecipeIngredient.quantity) < 100) {

        myIngArr.push({ quantity: this.newRecipeIngredient.quantity, unit: this.newRecipeIngredient.unit, ingredient: this.newRecipeIngredient.ingredient })
        console.log(myIngArr);
        this.recipeIngredientSource = new MatTableDataSource<Ingredient>(myIngArr);
        this.newRecipeIngredient.ingredient = '';
        this.newRecipeIngredient.quantity = '';
        this.newRecipeIngredient.unit = '';
      }
    }
  }

  revertChanges() {
    window.location.reload();
  }

}