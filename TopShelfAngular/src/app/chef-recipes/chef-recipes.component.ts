import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { IRecipes } from '../irecipes';
import { ChefRecipesService } from '../chef-recipes.service';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { Recipe } from '../models/recipe';

@Component({
  selector: 'app-chef-recipes',
  templateUrl: './chef-recipes.component.html',
  styleUrls: ['./chef-recipes.component.css']
})
export class ChefRecipesComponent implements OnInit {

  recipes: Recipe[] = [];
  searchExecuted = false;
  subscription: Subscription;
  noResultList: boolean = false;
  isHover: boolean[] = [false, false, false, false, false, false];
  searchIndex: number = 0;
  minSearchIndex: boolean = true;
  maxSearchIndex: boolean = true;

  user: User;

  constructor(private chefservice: ChefRecipesService, private router: Router) {
    if (localStorage.getItem('user')) {
      this.user = JSON.parse(localStorage.getItem('user'));
    } else {
      this.router.navigate(['login']);
    }

    this.chefservice.getAllChefRecipes(this.user.chef.id).subscribe(chefRecipe => {
      this.recipes = chefRecipe;
    });

    this.searchForRecipe(0);
  }

  ngOnInit() {
  }

  searchForRecipe(pageIndex: number) {
    if (pageIndex == 0) {
      this.minSearchIndex = true;
    }

    this.noResultList = false;
    pageIndex = this.searchIndex;

    this.searchExecuted = true;
    
     

      if (this.recipes.length == 0) {
        this.noResultList = true;
      }
      else if (this.recipes.length < 6) {
        this.maxSearchIndex = true;
      }
      else {
        this.maxSearchIndex = false;
        this.minSearchIndex = false;
        if (pageIndex == 0) {
          this.minSearchIndex = true;
        }
      }
  
  }

  nextPreviousQuery() {
    this.searchIndex--;
    this.maxSearchIndex = false;
    if (this.searchIndex < 0) {
      this.searchIndex == 0;
      this.minSearchIndex = true;
    }
    else {
      this.searchForRecipe(this.searchIndex);
    }
  }

  nextSearchQuery() {
    this.searchIndex++;
    this.minSearchIndex = false;

    this.searchForRecipe(this.searchIndex);
  }

  editRecipe(myRecipe: Recipe){

    localStorage.setItem('recipe', JSON.stringify(myRecipe));
    
    this.router.navigate(['edit-recipe']);

  }

}