import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MenuModule } from './shared/components/menu/menu.module';
import { MaterialModule } from './shared/modules/material.module';
// import { LoginComponent } from './auth/components/login/login.component';
import { HomeComponent } from './shared/components/home/home.component';
import { ArticleComponent } from './shared/components/article/article.component';
import { HealthComponent } from './shared/components/health/health.component';
import { RelationComponent } from './shared/components/relation/relation.component';
import { FinanceComponent } from './shared/components/finance/finance.component';
import { ArticlelistComponent } from './shared/components/articlelist/articlelist.component';
// import { AuthContainerComponent } from './auth/components/auth-container/auth-container.component';
// import { RegistrationComponent } from './auth/components/registration/registration.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTableModule} from '@angular/material/table';
@NgModule({
  declarations: [
    AppComponent,
//    LoginComponent,
    HomeComponent,
ArticleComponent,
HealthComponent,
RelationComponent,
FinanceComponent,
ArticlelistComponent,
    // AuthContainerComponent,
    // RegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    MaterialModule,
    MenuModule,
    MatPaginatorModule,
    MatTableModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
