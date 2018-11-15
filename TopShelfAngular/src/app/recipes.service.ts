import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IRecipes } from './irecipes';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipesService {

  private _url: string = 'https://swapi.co/api/planets/1/';

  constructor(private http : HttpClient) { }

  getRecipes(): Observable<IRecipes[]>{
    return this.http.get<IRecipes[]>(this._url);
  }
}
