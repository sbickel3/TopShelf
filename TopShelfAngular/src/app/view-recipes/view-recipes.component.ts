import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { RecipesService } from '../recipes.service';
import { IRecipes } from '../irecipes';
import { Subscription } from 'rxjs';
import * as parsing from '../parser/parse';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';

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

  displayedColumns: string[] = ['id', 'name', 'progress', 'color'];
  dataSource: MatTableDataSource<IRecipes>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private recipesService: RecipesService) {

    this.dataSource = new MatTableDataSource(this.resultList);

   }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
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

  // checkValue() {
  //   this.recipes.forEach((value: IRecipes[], index: number) => {
  //     this.resultList = value;
  //     console.log(index, value);
  //     console.log(this.resultList);
  //   });
  // }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

}
