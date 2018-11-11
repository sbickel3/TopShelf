import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PossibleRecipesComponent } from './possible-recipes.component';

describe('PossibleRecipesComponent', () => {
  let component: PossibleRecipesComponent;
  let fixture: ComponentFixture<PossibleRecipesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PossibleRecipesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PossibleRecipesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
