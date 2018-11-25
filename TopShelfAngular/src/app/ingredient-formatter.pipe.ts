import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ingredientFormatter'
})
export class IngredientFormatterPipe implements PipeTransform {

  transform(value: string): string {
    value.toLowerCase();
    value.trim();
    return value;
  }

}
