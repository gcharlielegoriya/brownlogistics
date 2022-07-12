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
import { WeekDataviewComponent } from './week-dataview/week-dataview.component';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';
import { UniquePipe } from './unique.pipe';
import { UniquedataPipe } from './weekly-summary/uniquedata.pipe';

@NgModule({
  declarations: [
    AppComponent,
    WeeklySummaryComponent,
    LoginComponent,
    ComingsoonComponent,
    DetailComponent,
      GetDetailWeekComponent,
      WeekDataviewComponent,
      UniquePipe
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
    HttpClientModule,
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: environment.production,
      // Register the ServiceWorker as soon as the app is stable
      // or after 30 seconds (whichever comes first).
      registrationStrategy: 'registerWhenStable:30000'
    })
  ],
  providers: [UniquePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
