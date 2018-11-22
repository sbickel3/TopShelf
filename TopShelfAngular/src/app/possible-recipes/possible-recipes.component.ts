import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-possible-recipes',
  templateUrl: './possible-recipes.component.html',
  styleUrls: ['./possible-recipes.component.css']
})
export class PossibleRecipesComponent implements OnInit {

  data: any;

  constructor(private http: HttpClient) {
    console.log(environment.apiURL + 'test');
    this.http.get(environment.apiURL + 'test', { responseType: 'text' })
      .subscribe(data => this.data = data);
  }

  ngOnInit() {
  }
}
