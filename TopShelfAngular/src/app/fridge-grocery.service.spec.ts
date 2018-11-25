import { TestBed } from '@angular/core/testing';

import { Fridge_Grocery_Service } from './fridge-grocery.service';

describe('FridgeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Fridge_Grocery_Service = TestBed.get(Fridge_Grocery_Service);
    expect(service).toBeTruthy();
  });
});
