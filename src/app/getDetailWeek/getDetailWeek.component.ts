import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-getDetailWeek',
  templateUrl: './getDetailWeek.component.html',
  styleUrls: ['./getDetailWeek.component.css']
})
export class GetDetailWeekComponent implements OnInit {
  approvedata: any;
  driverId: any;
  tripListData:any;
  searchText:any;  date:any ;
  status: any;

  constructor( private router: Router,
                  private http: HttpClient,
                  private activatedRoute: ActivatedRoute) {
                    this.activatedRoute.queryParams.subscribe(params => {
                      this.driverId = params['driverId'];
                      this.status= params['status']
                      console.log( this.driverId); // Print the parameter to the console.
                  });
                  }

  ngOnInit() {
    this.http.post<any>('http://localhost:7777/currentWeekSummaryData',{driverId:this.driverId}).subscribe(res=>{
      this.approvedata= res.currentWkList;
      if(this.status == "Unapproved") {
        this.tripListData= this.approvedata.filter( (book: { paidstatus: string; }) => book.paidstatus === "Unapproved");
      } else if(this.status == "Inprocess") {
        this.tripListData= this.approvedata.filter( (book: { paidstatus: string; }) => book.paidstatus === "Inprocess");
      } else {
        this.tripListData= this.approvedata.filter( (book: { paidstatus: string; }) => book.paidstatus === "Approved");
      }
    })
  }

  goback() {
    this.router.navigate(
      ['/app-weekly-summary'],
      { queryParams: { driverId: this.driverId } }
    );
  }

}
