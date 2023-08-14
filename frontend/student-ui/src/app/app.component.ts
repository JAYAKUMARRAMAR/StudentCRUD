import { Component, OnInit } from '@angular/core';
import { StudentService } from './student.service';
import { Student } from './student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'student dashboard';

  studentDetails:Student[]=[];

  constructor(private studentService: StudentService) {  }

  ngOnInit(): void {
    this.getStudentsDetails();
  }

  getStudentsDetails() {
    this.studentService.getStudents().subscribe(
      data=> {
        console.log("response received");
        this.studentDetails = data;
      },
      error => console.log("exception occured")
    )
  }
}
