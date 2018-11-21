import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedRecipeComponent } from './featured-recipe.component';

describe('FeaturedRecipeComponent', () => {
  let component: FeaturedRecipeComponent;
  let fixture: ComponentFixture<FeaturedRecipeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeaturedRecipeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedRecipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
