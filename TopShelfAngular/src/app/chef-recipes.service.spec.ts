import { TestBed } from '@angular/core/testing';

import { ChefRecipesService } from './chef-recipes.service';

describe('ChefRecipesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ChefRecipesService = TestBed.get(ChefRecipesService);
    expect(service).toBeTruthy();
  });
});
