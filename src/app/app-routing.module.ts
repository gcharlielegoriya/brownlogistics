import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetailComponent } from './detail/detail.component';
import { GetDetailWeekComponent } from './getDetailWeek/getDetailWeek.component';
import { LoginComponent } from './login/login.component';
import { WeeklySummaryComponent } from './weekly-summary/weekly-summary.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'app-weekly-summary', component: WeeklySummaryComponent },
  {path:'detail', component: DetailComponent},
  {path:'getdatalist',component: GetDetailWeekComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
