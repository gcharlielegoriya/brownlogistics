import { Component, OnInit, Input, ViewChild, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MAT_DATE_FORMATS } from '@angular/material/core';
import * as moment from 'moment';

export const APP_DATE_FORMATS = {
  parse: { dateInput: { month: 'short', day: 'numeric', year: 'numeric' } },
  display: {
    dateInput: { month: 'short', day: 'numeric', year: 'numeric' },
    monthYearLabel: { year: 'numeric' }
  }
};

@Component({
  selector: 'app-start-end-dates-duration',
  templateUrl: './start-end-dates-duration.component.html',
  // styleUrls: ['./start-end-dates-duration.component.scss'],
  providers: [
    {
      provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS
    }]
})
export class StartEndDatesDurationComponent implements OnInit {

  @Input() startDateLabel: string | undefined;
  @Input() endDateLabel: string | undefined;

  @Input() startDateInput: any;
  @Input() endDateInput: any;

  @ViewChild('startDateToggle', { static: false }) startDate: any;
  @ViewChild('endDateToggle', { static: false }) endDate: any;

  step = 1;

  @Output() StartEndDatesOutput = new EventEmitter();
  startEndDatesForm!: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.startEndDatesForm = this.fb.group({
      startDate: [''],
      endDate: [''],
      months: [0],
      days: [0],
      years: [0]
    });

    this.startEndDatesForm.controls['startDate'].setValue(this.startDateInput);
    this.startEndDatesForm.controls['months'].setValue(0);
    this.startEndDatesForm.controls['days'].setValue(0);
    if (this.startEndDatesForm.controls['startDate'].value) {
      if (this.endDateInput) {
        this.startEndDatesForm.controls['endDate'].setValue(this.endDateInput);
        this.endDateClicked();
      }
    }
  }

  startDateClicked() {
    this.StartEndDatesOutput.emit(this.getDates());
  }

  endDateClicked() {
    if (this.startEndDatesForm.controls['startDate'].value) {
      let eventStartTime = new Date(this.startEndDatesForm.controls['startDate'].value);
      let eventEndTime = new Date(this.startEndDatesForm.controls['endDate'].value);

      let m = moment(eventEndTime);
      let years = m.diff(eventStartTime, 'years');
      m.add(-years, 'years');
      let months = m.diff(eventStartTime, 'months');
      m.add(-months, 'months');
      let days = m.diff(eventStartTime, 'days');

      this.startEndDatesForm.controls['months'].setValue(months);
      this.startEndDatesForm.controls['years'].setValue(years);
      this.startEndDatesForm.controls['days'].setValue(days);
      this.StartEndDatesOutput.emit(this.getDates());
    } else {
      console.log('Please select the start date');
      this.startEndDatesForm.controls['endDate'].setValue('');
    }
  }


  monthsUp() {
    if (this.startEndDatesForm.controls['startDate'].value) {
      if (this.startEndDatesForm.controls['months'].value >= 0) {
        this.startEndDatesForm.controls['months'].setValue(this.startEndDatesForm.controls['months'].value + this.step);
        this.setEndDate();
      }
    } else {
      console.log('Please select the start date');
    }
  }

  yearsUp() {
    if (this.startEndDatesForm.controls['startDate'].value) {
      if (this.startEndDatesForm.controls['years'].value >= 0) {
        this.startEndDatesForm.controls['years'].setValue(this.startEndDatesForm.controls['years'].value + this.step);
        this.setEndDate();
      }
    } else {
      console.log('Please select the start date');
    }
  }

  monthsDown() {
    if (this.startEndDatesForm.controls['startDate'].value) {
      if (this.startEndDatesForm.controls['months'].value >= 1) {
        this.startEndDatesForm.controls['months'].setValue(this.startEndDatesForm.controls['months'].value - this.step);
        this.setEndDate();
      }
    } else {
      console.log('Please select the start date');
    }
  }

  yearsDown() {
    if (this.startEndDatesForm.controls['startDate'].value) {
      if (this.startEndDatesForm.controls['years'].value >= 1) {
        this.startEndDatesForm.controls['years'].setValue(this.startEndDatesForm.controls['years'].value - this.step);
        this.setEndDate();
      }
    } else {
      console.log('Please select the start date');
    }
  }

  daysUp() {
    if (this.startEndDatesForm.controls['startDate'].value) {
      if (this.startEndDatesForm.controls['days'].value >= 0 && this.startEndDatesForm.controls['days'].value < 30) {
        this.startEndDatesForm.controls['days'].setValue(this.startEndDatesForm.controls['days'].value + this.step);
        this.setEndDate();
      }
    } else {
      console.log('Please select the start date');
    }
  }

  daysDown() {
    if (this.startEndDatesForm.controls['startDate'].value) {
      if (this.startEndDatesForm.controls['days'].value >= 1) {
        this.startEndDatesForm.controls['days'].setValue(this.startEndDatesForm.controls['days'].value - this.step);
        this.setEndDate();
      }
    } else {
      console.log('Please select the start date');
    }
  }

  setEndDate() {
    this.startEndDatesForm.controls['endDate'].setValue(moment(new Date(this.startEndDatesForm.controls['startDate'].value))
      .add(this.startEndDatesForm.controls['days'].value, 'days')
      .add(this.startEndDatesForm.controls['months'].value, 'months')
      .add(this.startEndDatesForm.controls['years'].value, 'years')
      .local().format());

    this.StartEndDatesOutput.emit(this.getDates());
  }

  getDates() {
    let startEndDates = {
      'startDate': this.startEndDatesForm.controls['startDate'].value,
      'endDate': this.startEndDatesForm.controls['endDate'].value
    };
    return startEndDates;
  }

  convert(str: string | number | Date) {
    let date = new Date(str),
      mnth = ('0' + (date.getMonth() + 1)).slice(-2),
      day = ('0' + date.getDate()).slice(-2);
    return [date.getFullYear(), mnth, day].join('-');
  }

}
