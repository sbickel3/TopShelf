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
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);
  selection = new SelectionModel<PeriodicElement>(true, []);

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
  }

}
