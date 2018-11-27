import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChefRecipesComponent } from './chef-recipes.component';

describe('ChefRecipesComponent', () => {
  let component: ChefRecipesComponent;
  let fixture: ComponentFixture<ChefRecipesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChefRecipesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChefRecipesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
