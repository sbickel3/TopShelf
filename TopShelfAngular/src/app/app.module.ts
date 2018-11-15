import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule }from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { UiModule } from './ui/ui.module';
import { LoginComponent } from './login/login.component';
import { SplashComponent } from './splash/splash.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { LayoutComponent } from './layout/layout.component';
import { RegisterComponent } from './register/register.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { ViewRecipesComponent } from './view-recipes/view-recipes.component';
import { FeaturedRecipeComponent } from './featured-recipe/featured-recipe.component';
import { AddRecipesComponent } from './add-recipes/add-recipes.component';
import { ChecklistComponent } from './checklist/checklist.component';
import { PossibleRecipesComponent } from './possible-recipes/possible-recipes.component';
import { AboutComponent } from './about/about.component';
import { UserService } from './user.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    LayoutComponent,
    FooterComponent,
    SplashComponent,
    RegisterComponent,
    UserHomeComponent,
    ViewRecipesComponent,
    FeaturedRecipeComponent,
    AddRecipesComponent,
    ChecklistComponent,
    PossibleRecipesComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    UiModule,
    FormsModule, // necessary for two-way data binding using ngModel
    HttpClientModule,
    RouterModule.forRoot([
      {
        path: 'splash',
        component: SplashComponent
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'register',
        component: RegisterComponent
      },
      {
        path: 'add-recipes',
        component: AddRecipesComponent,
        canActivate: [UserService]
      },
      {
        path: 'checklist',
        component: ChecklistComponent,
        canActivate: [UserService]
      },
      {
        path: 'featured-recipe',
        component: FeaturedRecipeComponent
      },
      {
        path: 'possible-recipes',
        component: PossibleRecipesComponent,
        canActivate: [UserService]
      },
      {
        path: 'user-home',
        component: UserHomeComponent
      },
      {
        path: 'view-recipes',
        component: ViewRecipesComponent
      },
      {
        path: 'about',
        component: AboutComponent
      },
      {
        path: '',
        component: SplashComponent
      }
    ])
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
