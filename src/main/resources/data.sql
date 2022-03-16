INSERT INTO Task (id, global_id, name, description, input_parameter, output_parameter)
VALUES (TASK_SEQ.nextval,
        '31fb02407d5946018465e59ca96109b1',
        'ReverseString',
        'Please write a program to reverse the incoming string and send it to System.out\n For example input string:  hello world,  output string: dlrow olleh',
        'hello world',
        'dlrow olleh');

INSERT INTO Task (id, global_id, name, description, input_parameter, output_parameter)
VALUES (TASK_SEQ.nextval,
        '31fb02407d5946018465e59ca96109b2',
        'DoubleString',
        'Please write a program that repeats the input string one space and sends it to System.out.\n For example input string:  hello,  output string: hello hello',
        'hello',
        'hello hello');


INSERT INTO Task (id, global_id, name, description, input_parameter, output_parameter)
VALUES (TASK_SEQ.nextval,
        '31fb02407d5946018465e59ca96109b3',
        'RemoveSpaces',
        'Please write a program that remove spaces from the input string and sends it to System.out.\n For example input string:  h e l l o,  output string: hello',
        'h e l l o',
        'hello');

INSERT INTO Task (id, global_id, name, description, input_parameter, output_parameter)
VALUES (TASK_SEQ.nextval,
        '31fb02407d5946018465e59ca96109b4',
        'CalculateFactorial',
        'Please write a program that calculate factorial from the input and sends it to System.out.\n For example input string:  11,  output string: 39916800',
        '11',
        '39916800');

INSERT INTO Task (id, global_id, name, description, input_parameter, output_parameter)
VALUES (TASK_SEQ.nextval,
        '31fb02407d5946018465e59ca96109b5',
        'RaiseToThePowerOf10',
        'Please write a program that calculate raise to the power of 10 from the input and sends it to System.out.\n For example input string:  5,  output string: 9765625',
        '5',
        '9765625');