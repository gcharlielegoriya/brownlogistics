/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { StartEndDatesDurationComponent } from './start-end-dates-duration.component';

describe('StartEndDatesDurationComponent', () => {
  let component: StartEndDatesDurationComponent;
  let fixture: ComponentFixture<StartEndDatesDurationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartEndDatesDurationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartEndDatesDurationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
