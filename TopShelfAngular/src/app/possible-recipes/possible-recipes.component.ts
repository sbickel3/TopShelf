import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Fridge_Grocery_Service } from '../fridge-grocery.service';
import { User } from '../models/user';
import { Fridge } from '../models/fridge';

@Component({
  selector: 'app-possible-recipes',
  templateUrl: './possible-recipes.component.html',
  styleUrls: ['./possible-recipes.component.css']
})
export class PossibleRecipesComponent implements OnInit {

  user: User;
  myFridge: Fridge;
  displayedColumns: string[];

  fridgeSource;
  fridgeSelection;
  

    
  constructor(private fgService: Fridge_Grocery_Service) {
    this.user = this.fgService.user;
    this.myFridge = this.fgService.myFridge;

    this.displayedColumns = this.fgService.displayedColumns;

    this.fridgeSource = this.fgService.fridgeSource;
    this.fridgeSelection = this.fgService.fridgeSelection;

  }

  ngOnInit() {
  }

  isAllSelectedInFridge() {
    this.fgService.isAllSelectedInFridge();
  }

  masterToggleFridge() {
    this.fgService.masterToggleFridge();
  }
}
