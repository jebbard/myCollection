import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CollectionBasicsComponent } from './collection-basics.component';

describe('CollectionBasicsComponent', () => {
  let component: CollectionBasicsComponent;
  let fixture: ComponentFixture<CollectionBasicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CollectionBasicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CollectionBasicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
