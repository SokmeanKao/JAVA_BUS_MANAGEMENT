# Bus Management System

## Setup Bus
### Setting up Bus
```plaintext
-> Enter number of Bus: 2
-> Enter number Seat of bus: 45
```

## Display Bus
### Bus Management System Menu
```plaintext
1- Check Bus
2- Booking Bus
3- Cancel Booking
4- Reset Bus
5- Exit
---------------------------------------------
-> Choose option (1-5): 1
```

### Display All Bus Information
```plaintext
---------- Display All Bus information ----------
Id   Seat   Available   Unavailable
1    45     45          0
2    45     45          0
-> Enter 0 to back or Bus Id to see detail: 1
```

### Display Bus Information
```plaintext
---------- Display Bus information ----------
(+) 1    (+) 2       (+) 3 (+) 4 (+) 5
(+) 6    (+) 7       (+) 8 (+) 9 (+) 10
(+) 11   (+) 12      (+) 13 (+) 14 (+) 15
(+) 16   (+) 17      (+) 18 (+) 19 (+) 20
(+) 21   (+) 22      (+) 23 (+) 24 (+) 25
(+) 26   (+) 27      (+) 28 (+) 29 (+) 30
(+) 31   (+) 32      (+) 33 (+) 34 (+) 35
(+) 36   (+) 37      (+) 38 (+) 39 (+) 40
(+) 41   (+) 42      (+) 43 (+) 44 (+) 45

( - ) : Unavailable (0)   ( + ) : Available (45)
```

## Booking Bus
### Booking Process
```plaintext
-> Choose option (1-5): 2
-> Enter bus’s Id: 1
---------- Display Bus information ----------
(+) 1    (+) 2       (+) 3 (+) 4 (+) 5
(+) 6    (+) 7       (+) 8 (+) 9 (+) 10
...
-> Enter Chair number to booking: 2
-> Do you want to book chair number 2? (y/n): y
Chair number 2 was booked successfully!
```

## Cancel Booking
### Cancel Booking Process
```plaintext
-> Choose option (1-5): 3
-> Enter bus’s Id: 1
---------- Display Bus information ----------
(+) 1    (-) 2       (+) 3 (+) 4 (+) 5
...
-> Enter Seat number to cancel booking: 2
-> Do you want to cancel book chair number 2? (y/n): y
Seat number 2 was canceled booking successfully!
```

## Reset Bus
### Reset Process
```plaintext
-> Choose option (1-5): 4
-> Enter bus’s Id: 2
-> Bus id 2 was reset with all seats available? (y/n): y
Bus id 2 was reset successfully
```

## Exit the Application
### Exit Process
```plaintext
-> Choose option (1-5): 5
-> Good bye!
```

## Bonus Features
- **Color:** Customizable color schemes.
- **Pagination:** Navigation options (First, Next, Previous, Last).
- **Display Data in Table:** Enhanced tabular format for bus information.
- **Additional Enhancements:** Flexible and extendable for more features.

## Implementation Note
- Use two-dimensional arrays for data representation.
- Utilize control flow statements for menu-driven application logic.

