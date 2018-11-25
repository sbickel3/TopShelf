import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { SelectionModel } from '@angular/cdk/collections';
import { MatTableDataSource } from '@angular/material';
import { Fridge } from '../models/fridge';
import { Grocery } from '../models/grocery';
import { Ingredient } from '../models/ingredient';
import { Chef } from '../models/chef';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

const HTTP_OPTIONS = {
  headers: new HttpHeaders({
    'Content-type': 'application/json'
  })
};

@Component({
  selector: 'app-checklist',
  templateUrl: './checklist.component.html',
  styleUrls: ['./checklist.component.css']
})
export class ChecklistComponent implements OnInit {

  user: User;
  myInfo: Chef;
  myFridge: Fridge;
  myGrocery: Grocery;
  newFridgeIngredient = new Ingredient();
  newGroceryIngredient = new Ingredient();

  // Holder for our edited fridge and grocery lists
  tempFridge: Ingredient[];
  tempGrocery: Ingredient[];

  displayedColumns: string[];

  // info for Fridge tables
  fridgeSource;
  fridgeSelection;

  // info for Grocery Table
  grocerySource;
  grocerySelection;

  constructor(private http: HttpClient) {
    this.user = JSON.parse(localStorage.getItem('user'));
    this.myInfo = this.user.chef;
    this.myFridge = this.user.fridge;
    this.myGrocery = this.user.grocery;

    this.tempFridge = this.myFridge.ingredient;
    this.tempGrocery = this.myGrocery.ingredient;

    this.displayedColumns = ['select', 'quantity', 'unit', 'ingredient'];

    this.fridgeSource = new MatTableDataSource<Ingredient>(this.tempFridge);
    this.fridgeSelection = new SelectionModel<Ingredient>(true, []);

    this.grocerySource = new MatTableDataSource<Ingredient>(this.tempGrocery);
    this.grocerySelection = new SelectionModel<Ingredient>(true, []);
  }

  ngOnInit() { }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelectedInFridge() {
    const numSelected = this.fridgeSelection.selected.length;
    const numRows = this.fridgeSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggleFridge() {
    this.isAllSelectedInFridge() ?
      this.fridgeSelection.clear() :
      this.fridgeSource.data.forEach(row => this.fridgeSelection.select(row));
  }

  isAllSelectedInGrocery() {
    const numSelected = this.grocerySelection.selected.length;
    const numRows = this.grocerySource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggleGrocery() {
    this.isAllSelectedInGrocery() ?
      this.grocerySelection.clear() :
      this.grocerySource.data.forEach(row => this.grocerySelection.select(row));
  }

  removeFromFridge() {
    this.fridgeSelection.selected.forEach(item => {
      let index: number = this.fridgeSource.data.findIndex(d => d === item);
      this.fridgeSource.data.splice(index, 1);
      this.fridgeSource = new MatTableDataSource<Ingredient>(this.fridgeSource.data);
    });
    this.fridgeSelection = new SelectionModel<Ingredient>(true, []);
    console.log(this.fridgeSource.data);
  }

  moveToFridge() {
    let myIngArr: Ingredient[];
    myIngArr = this.fridgeSource.data;

    this.grocerySelection.selected.forEach(item => {
      myIngArr.push(item);
    });

    this.removeFromGrocery();
    this.fridgeSource = new MatTableDataSource<Ingredient>(myIngArr);
    this.fridgeSelection = new SelectionModel<Ingredient>(true, []);
  }

  addToFridge() {
    let myIngArr: Ingredient[];
    myIngArr = this.fridgeSource.data;

    console.log(myIngArr);

    myIngArr.push(this.newFridgeIngredient);

    console.log(myIngArr);

    this.fridgeSource = new MatTableDataSource<Ingredient>(myIngArr);

    this.newFridgeIngredient.ingredient = "";
    this.newFridgeIngredient.quantity = "";
    this.newFridgeIngredient.unit = "";
  }

  removeFromGrocery() {
    this.grocerySelection.selected.forEach(item => {
      let index: number = this.grocerySource.data.findIndex(d => d === item);
      this.grocerySource.data.splice(index, 1);
      this.grocerySource = new MatTableDataSource<Element>(this.grocerySource.data);
    });

    this.grocerySelection = new SelectionModel<Element>(true, []);
    console.log(this.grocerySource.data);
  }

  moveToGrocery() {
    let myIngArr: Ingredient[];
    myIngArr = this.grocerySource.data;

    this.fridgeSelection.selected.forEach(item => {
      myIngArr.push(item);
    });

    this.removeFromFridge();
    this.grocerySource = new MatTableDataSource<Ingredient>(myIngArr);
    this.grocerySelection = new SelectionModel<Ingredient>(true, []);
  }

  commitChanges() {
    // Put new list into fridge object
    this.myFridge.ingredient = this.tempFridge;

    let fridgeJSON = JSON.stringify(this.myFridge);

    console.log(fridgeJSON);
    this.http.put<Fridge>(environment.apiURL + 'fridge/update', fridgeJSON, HTTP_OPTIONS).subscribe(response => {
      this.updateUser(); 
    });

    // Put new list into grocery object
    this.myGrocery.ingredient = this.tempGrocery;

    let groceryJSON = JSON.stringify(this.myGrocery);

    console.log(groceryJSON);
    this.http.put<Grocery>(environment.apiURL + 'grocerylist/update', groceryJSON, HTTP_OPTIONS).subscribe(response => {
      localStorage.setItem('grocery', JSON.stringify(this.myGrocery.ingredient));
      this.updateUser(); 
    });

  }

  updateUser() {
    this.user.fridge = this.myFridge;
    this.user.grocery = this.myGrocery;

    localStorage.setItem('user', JSON.stringify(this.user));
  }

  revertChanges() {
    window.location.reload();
  }

}
