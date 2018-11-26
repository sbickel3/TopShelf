import { Ingredient } from "./ingredient";

export class Recipe {
   id: number;
   name: string;
   instruction: string;
   photo: string;
   chefId: number;
   ingredient: {};
   ingredientList: Ingredient[];
}