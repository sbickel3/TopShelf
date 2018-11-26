import { Injectable } from '@angular/core';
import { Fridge } from './models/fridge';
import { MatTableDataSource } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';
import { Ingredient } from './models/ingredient';
import { User } from './models/user';


@Injectable({
  providedIn: 'root'
})

export class Fridge_Grocery_Service {

  user: User;
  myFridge: Fridge;

  displayedColumns: string[];

  fridgeSource;
  fridgeSelection;

  constructor() {
    this.user = JSON.parse(localStorage.getItem('user'));
    this.myFridge = this.user.fridge;
    this.displayedColumns = ['select', 'quantity', 'unit', 'ingredient'];
    this.fridgeSource = new MatTableDataSource<Ingredient>(this.myFridge.ingredient);
    this.fridgeSelection = new SelectionModel<Ingredient>(true, []);
  }

  ngOnInit() { }

  isAllSelectedInFridge() {
    const numSelected = this.fridgeSelection.selected.length;
    const numRows = this.fridgeSource.data.length;
    return numSelected === numRows;
  }

  masterToggleFridge() {
    this.isAllSelectedInFridge() ?
      this.fridgeSelection.clear() :
      this.fridgeSource.data.forEach(row => this.fridgeSelection.select(row));
  }


}
