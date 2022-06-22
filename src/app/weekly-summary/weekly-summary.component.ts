import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-weekly-summary',
  templateUrl: './weekly-summary.component.html',
  styleUrls: ['./weekly-summary.component.css']
})
export class WeeklySummaryComponent implements OnInit {
  searchText:any;  date:any ;
  filterOnAge:any;
  fg!: FormGroup;
  tripListData :any
  driverId: any;
  completed: any;
  earning: any;
  inProgress: any;
  completedtrip: any;
  approvedata: any;
  flag: boolean = false;

  constructor(private activatedRoute: ActivatedRoute,
              private http: HttpClient,
              private router: Router) {
    this.activatedRoute.queryParams.subscribe(params => {
      this.driverId = params['driverId'];
      console.log( this.driverId); // Print the parameter to the console.
  });
  }

  ngOnInit(): void {
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
    console.log(data.target.id);
    this.router.navigate(
      ['/getdatalist'],
      { queryParams: { driverId: this.driverId , status: data.target.id} }
    );

  }

  inprogress(){

  }

  completeTrip(){

  }


  StartEndDatesOutput(event:any){
    this.date = event;
    console.log(event);
  }

  dashboardDataget(){
    this.http.post<any>(`http://localhost:7777/getDashboardDetails `,{driverId:this.driverId}).subscribe(res=>{
      console.log(res);
      this.completedtrip = res.complete;
      this.earning = res.earning;
      this.inProgress =res.inProgress
    })
  }


  getTripAll() {
    this.http.post<any>('http://localhost:7777/getAllTripDetails',{driverId:this.driverId} ).subscribe(res=>{
      this.tripListData = res.tripDetails;
      console.log(this.tripListData);
      this.filterOnAge = this.tripListData.filter((person: { paidStatus: string; }) => person.paidStatus === 'Paid' );
    })
  }

  // private dateRangeValidator: ValidatorFn = (): {
  //   [key: string]: any;
  // } | null => {
  //   let invalid = false;
  //   // const from = this.fg.get("from").value;
  //   // const to = this.fg && this.fg.get("to").value;
  //   // if (from && to) {
  //   //   invalid = new Date(from).valueOf() > new Date(to).valueOf();
  //   // }
  //   // return invalid ? { invalidRange: { from, to } } : null;
  // };


  // hero(m:any) {
  //   this.router.('')
  // }

  getTripDetails(id:any) {
    this.router.navigate(
      ['/detail'],
      { queryParams: { frieghtId: id ,driverId: this.driverId } }
    );
  }
}
