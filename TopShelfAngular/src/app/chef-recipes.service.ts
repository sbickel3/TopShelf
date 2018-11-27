import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Recipe } from './models/recipe';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';
import { User } from './models/user';

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ChefRecipesService {

  constructor(private http: HttpClient, private router: Router) { }

  addNewChefRecipe(recipe: Recipe): Observable<Recipe>{
    let user: User;
    user = JSON.parse(localStorage.getItem('user'));
    recipe.chefId = user.chef.id;
    let recipeJSON = JSON.stringify(recipe);
    return this.http.post<Recipe>(environment.apiURL + 'recipe/new', recipeJSON, HTTP_OPTIONS);
  }

  getAllChefRecipes(chefId: number): Observable<Recipe[]>{
    return this.http.get<Recipe[]>(environment.apiURL + `recipe/${chefId}`);
  }

  updateChefRecipe(recipe: Recipe): Observable<Recipe>{
    let recipeJSON = JSON.stringify(recipe);
    return this.http.put<Recipe>(environment.apiURL + 'recipe/update', recipeJSON, HTTP_OPTIONS);
  }

  deleteChefRecipe(recipe: Recipe): Observable<Recipe>{
    return this.http.delete<Recipe>(environment.apiURL + `recipe/delete/${recipe.id}`, HTTP_OPTIONS);
  }
}