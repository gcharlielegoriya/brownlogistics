import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { filter } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UniquedataPipe } from './uniquedata.pipe';

const headerOptions = {

  headers: new HttpHeaders({

    'Content-Type': 'application/json',

    'Access-Control-Allow-Origin': '*',

    'Access-Control-Allow-Headers': 'Content-Type',

    'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',

  }),

};
@Component({
  selector: 'app-weekly-summary',
  templateUrl: './weekly-summary.component.html',
  styleUrls: ['./weekly-summary.component.css'],
  providers:[UniquedataPipe]
})

export class WeeklySummaryComponent implements OnInit {
  public API_URL = environment.API_URL;
  searchText:any;  paidDate:any ;
  contactForm!: FormGroup;
  filterOnAge:any;
  fg!: FormGroup;
  tripListData :any
  driverId: any;
  completed: any;
  condition: boolean = true;
  earning: any;
  inProgress: any;
  activeButton:any;
  completedtrip: any;
  approvedata: any;
  flag: boolean = false;
  filterData: any;
  dategg: any;

  constructor(private activatedRoute: ActivatedRoute,
              private http: HttpClient,
              private router: Router,
              private fb:FormBuilder) {
    this.activatedRoute.queryParams.subscribe(params => {
      this.driverId = params['driverId'];
  });
  }

  ngOnInit(): void {
    this.contactForm = this.fb.group({
      paidDate: [null]
    });
    this.dashboardDataget();
    this.getTripAll();
    // this.notPaid();
    this.fg = new FormGroup(
      {
        from: new FormControl(""),
        to: new FormControl("")
      },
      [Validators.required]
    );



  }

  notPaid(data:any){
    this.router.navigate(
      ['/getdatalist'],
      { queryParams: { driverId: this.driverId , status: data.target.id} }
    );

  }


  StartEndDatesOutput(event:any){
    this.paidDate = event;
  }

  dashboardDataget(){
    this.http.post<any>(this.API_URL + 'getDashboardDetails',{driverId:this.driverId},headerOptions).subscribe(res=>{
      this.completedtrip = res.complete;
      this.earning = res.earning;
      this.inProgress =res.inProgress
    })
  }

  clicked(even:any){
    if(even.currentTarget.id == 'pills-profile-tab'){
      this.condition = true;
      this.contactForm.get('paidDate')?.setValue(null);
    }
  }

  showPhase(event:any){
    console.log(event)
  }


  getTripAll() {
    this.http.post<any>(this.API_URL + 'getAllTripDetails',{driverId:this.driverId},headerOptions).subscribe(res=>{
      this.tripListData = res.tripDetails;
      this.filterOnAge = [...new Set(this.tripListData.map((item: { paidDate: any; }) => item.paidDate))];
    })
  }

  getTripDetails(id:any) {
    this.router.navigate(
      ['/detail'],
      { queryParams: { frieghtId: id ,driverId: this.driverId } }
    );
  }

}
