import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { SelectionModel } from '@angular/cdk/collections';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-checklist',
  templateUrl: './checklist.component.html',
  styleUrls: ['./checklist.component.css']
})
export class ChecklistComponent implements OnInit {

  user: User[][];
  myInfo: User[];
  myFridge: User[];
  myGrocery: User[];

  // info for tables
  displayedColumns: string[];
  dataSource;
  selection;

  constructor() {
    this.user = JSON.parse(localStorage.getItem('user'));
    this.myInfo = this.user[0];
    this.myFridge = this.user[1];
    this.myGrocery = this.user[2];
    console.log(this.myInfo);
    console.log(this.myFridge);
    console.log(this.myGrocery);
    this.displayedColumns = ['select', 'quantity', 'unit', 'ingredient']
    this.dataSource = new MatTableDataSource<User>(this.myFridge)
    this.selection = new SelectionModel<User>(true, [])
  }

  ngOnInit() {
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
        this.selection.clear() :
        this.dataSource.data.forEach(row => this.selection.select(row));
  }

}
