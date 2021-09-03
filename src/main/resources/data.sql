insert into ingredient(name,amount,unit, created_date, ingredient_type)
values
      ('broccoli',250,'GRAM',timezone('Europe/Istanbul',now()::timestamptz),'VEGETARIAN'),
      ('onion',600,'GRAM',timezone('Europe/Istanbul',now()::timestamptz),'VEGETARIAN'),
      ('potato',1,'KILOGRAM',timezone('Europe/Istanbul',now()::timestamptz),'VEGETARIAN'),
      ('water',1000,'LITER',timezone('Europe/Istanbul',now()::timestamptz),'VEGETARIAN'),
      ('soy sauce',50,'MILLILITER',timezone('Europe/Istanbul',now()::timestamptz),'VEGETARIAN'),
      ('milk',250,'MILLILITER',timezone('Europe/Istanbul',now()::timestamptz),'VEGETARIAN'),
      ('ground beef',500,'GRAM',timezone('Europe/Istanbul',now()::timestamptz),'NON_VEGETARIAN'),
      ('rice',300,'GRAM',timezone('Europe/Istanbul',now()::timestamptz),'VEGETARIAN'),
      ('beans',200,'GRAM',timezone('Europe/Istanbul',now()::timestamptz),'VEGETARIAN'),
      ('lettuce',400,'GRAM',timezone('Europe/Istanbul',now()::timestamptz),'VEGETARIAN'),
      ('chicken breast',700,'GRAM',timezone('Europe/Istanbul',now()::timestamptz),'NON_VEGETARIAN'),
      ('tuna',100,'GRAM',timezone('Europe/Istanbul',now()::timestamptz),'NON_VEGETARIAN'),
      ('almond milk',350,'MILLILITER',timezone('Europe/Istanbul',now()::timestamptz),'VEGETARIAN');



