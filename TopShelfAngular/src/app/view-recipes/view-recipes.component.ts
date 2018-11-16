import { Component, OnInit, OnDestroy } from '@angular/core';
import { RecipesService } from '../recipes.service';
import { IRecipes } from '../irecipes';
import { Subscribable, Subscription } from 'rxjs';

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

  constructor(private recipesService: RecipesService) {}
  
  ngOnInit() {
  }

  searchForRecipe() {
    console.log("SEARCHING")
    this.searchExecuted = true;
    let searchQuery = (<HTMLInputElement>document.getElementById('searchQuery')).value;
    
    this.subscription = this.recipesService.getRecipes(searchQuery).subscribe(apiRecipes => this.recipes.push(apiRecipes));
    console.log(this.recipes);
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
