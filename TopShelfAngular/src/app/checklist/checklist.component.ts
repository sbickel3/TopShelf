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
  displayedColumns: string[] = ['select', 'quantity', 'unit', 'ingredient'];
  dataSource = new MatTableDataSource<User>(this.myFridge);
  selection = new SelectionModel<User>(true, []);

  constructor() {
    this.user = JSON.parse(localStorage.getItem('user'));
    this.myInfo = this.user[0];
    this.myFridge = this.user[1];
    this.myGrocery = this.user[2];
    console.log(this.myInfo);
    console.log(this.myFridge);
    console.log(this.myGrocery);
  }

  ngOnInit() {
    let displayedColumns: string[] = ['select', 'quantity', 'unit', 'ingredient'];
    let dataSource = new MatTableDataSource<User>(this.myFridge);
    let selection = new SelectionModel<User>(true, []);
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
