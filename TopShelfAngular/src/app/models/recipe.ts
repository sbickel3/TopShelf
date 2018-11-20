import {Ingredient} from './ingredient';

export class Recipe {
    name: string;
    instruction: string;
    photo: string;
    chef_id: number;
    ingredient: Ingredient[];
}