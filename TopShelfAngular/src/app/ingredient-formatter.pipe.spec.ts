import { IngredientFormatterPipe } from './ingredient-formatter.pipe';

describe('IngredientFormatterPipe', () => {
  it('create an instance', () => {
    const pipe = new IngredientFormatterPipe();
    expect(pipe).toBeTruthy();
  });
});
