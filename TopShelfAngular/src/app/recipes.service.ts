import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IRecipes } from './irecipes';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipesService {

  recipesInt: IRecipes;

  constructor(private http : HttpClient) { }

  getFridgeRecipes(searchQuery: string): Observable<IRecipes[]>{
    console.log(searchQuery);
    let getUrl = `https://api.edamam.com/search?q=${searchQuery}&app_id=3ad898c0&app_key=ae004b4d0416313e74ed70c52060eb6e&from=0&to=3`;
    return this.http.get<IRecipes[]>(getUrl);
  }

  getRecipes(searchQuery: string, searchIndex: number): Observable<IRecipes>{
    console.log(searchQuery);
    let fromIndex = searchIndex*6;
    let toIndex = searchIndex*6 + 6;
    let getUrl = `https://api.edamam.com/search?q=${searchQuery}&app_id=3ad898c0&app_key=ae004b4d0416313e74ed70c52060eb6e&from=${fromIndex}&to=${toIndex}`;
    return this.http.get<IRecipes>(getUrl);
  }

  getFeatureRecipes(searchQuery: string, searchIndex: number): Observable<IRecipes>{
    console.log(searchQuery);
    let fromIndex = searchIndex;
    let toIndex = searchIndex+1;
    let getUrl = `https://api.edamam.com/search?q=${searchQuery}&app_id=3ad898c0&app_key=ae004b4d0416313e74ed70c52060eb6e&from=${fromIndex}&to=${toIndex}`;
    return this.http.get<IRecipes>(getUrl);
  }
}
