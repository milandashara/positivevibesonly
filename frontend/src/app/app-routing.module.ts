import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './shared/components/home/home.component';
import {HealthComponent} from './shared/components/health/health.component';
// import { LoginComponent } from './auth/components/login/login.component';
// import { RegistrationComponent } from './auth/components/registration/registration.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent, data: {category: 'health'}
  //   children: [
  //   { path: 'item', loadChildren: () => import('./test/test.module').then(mod => mod.TestModule) }
  // ]
  },
  { path: 'health', component: HomeComponent, data: {category: 'health'}},
  { path: 'relation', component: HomeComponent, data: {category: 'relation'}},
  { path: 'finance', component: HomeComponent, data: {category: 'finance'}},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
