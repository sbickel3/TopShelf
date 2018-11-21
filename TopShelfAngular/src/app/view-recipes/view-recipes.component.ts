import { Component, OnInit, OnDestroy } from '@angular/core';
import { RecipesService } from '../recipes.service';
import { IRecipes } from '../irecipes';
import { Subscription } from 'rxjs';
import * as parsing from '../parser/parse';

@Component({
  selector: 'app-view-recipes',
  templateUrl: './view-recipes.component.html',
  styleUrls: ['./view-recipes.component.css']
})
export class ViewRecipesComponent implements OnInit, OnDestroy {

  recipes: IRecipes[][] = new Array();
  recipesInt: IRecipes;
  searchExecuted = false;
  subscription: Subscription;
  resultList: IRecipes[] = [];

  constructor(private recipesService: RecipesService) { }

  ngOnInit() {
  }

  searchForRecipe() {
    this.recipes.length = 0;
    console.log("SEARCHING")
    this.searchExecuted = true;
    let searchQuery = (<HTMLInputElement>document.getElementById('searchQuery')).value;
    this.subscription = this.recipesService.getRecipes(searchQuery).subscribe(apiRecipes => this.recipes.push(apiRecipes));
    
  }

  parseIngredients(ingr: string) {
    parsing.parse(ingr);
  }

  checkValue() {
    this.recipes.forEach((value: IRecipes[], index: number) => {
      this.resultList = value;
      console.log(index, value);
      console.log(this.resultList);
    });
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

}
