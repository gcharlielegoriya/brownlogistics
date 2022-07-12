import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeekDataviewComponent } from './week-dataview.component';

describe('WeekDataviewComponent', () => {
  let component: WeekDataviewComponent;
  let fixture: ComponentFixture<WeekDataviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WeekDataviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WeekDataviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
