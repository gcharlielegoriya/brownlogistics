import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CodeInputModule } from 'angular-code-input';

import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WeeklySummaryComponent } from './weekly-summary/weekly-summary.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { ComingsoonComponent } from './comingsoon/comingsoon.component';
import { StartEndDatesModule } from './start-end-dates/start-end-dates.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DetailComponent } from './detail/detail.component';
import { GetDetailWeekComponent } from './getDetailWeek/getDetailWeek.component';

@NgModule({
  declarations: [
    AppComponent,
    WeeklySummaryComponent,
    LoginComponent,
    ComingsoonComponent,
    DetailComponent,
      GetDetailWeekComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CodeInputModule,
    FormsModule,
    Ng2SearchPipeModule,
    StartEndDatesModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
