import { Component, OnInit } from '@angular/core';
import { RecipesService } from '../recipes.service';

@Component({
  selector: 'app-view-recipes',
  templateUrl: './view-recipes.component.html',
  styleUrls: ['./view-recipes.component.css']
})
export class ViewRecipesComponent implements OnInit {

  public recipes = [];
  

  constructor(private recipesService: RecipesService) { }
  
  ngOnInit() {
    this.recipesService.getRecipes().subscribe(data => this.recipes.push(data));
  }

}
