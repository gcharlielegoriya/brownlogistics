import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { StartEndDatesDurationComponent } from './start-end-dates-duration/start-end-dates-duration.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from 'mat-input';
import { MatNativeDateModule } from '@angular/material/core';

@NgModule({
  imports: [
    CommonModule, FormsModule, ReactiveFormsModule, MatInputModule,MatDatepickerModule,MatNativeDateModule
  ],
  declarations: [StartEndDatesDurationComponent],
  exports: [StartEndDatesDurationComponent]
})
export class StartEndDatesModule { }
