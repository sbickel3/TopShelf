import { Component, OnInit } from '@angular/core';
import { Recipe } from '../models/recipe';

@Component({
  selector: 'app-add-recipes',
  templateUrl: './add-recipes.component.html',
  styleUrls: ['./add-recipes.component.css']
})
export class AddRecipesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  newRecipe: Recipe = new Recipe();
  isValid = true;
  registerSuccess = false;


  // register() {
  //   this.userService.registerUser(this.user).subscribe(user => {
  //     if(!user){
  //       this.isValid = false;
  //     } else{
  //       console.log(`User, ${this.user.username}, successfully logged in!`);
  //       this.registerSuccess = true;
  //       this.router.navigate(['login']);
  //     }
  //   })
  // }

}
