import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';

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
