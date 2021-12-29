<html>
    <head>
        <style>
            div.background-box {
                border-radius: 5px;
                background-color: #d3d2d2;
                width: 700px;
                padding: 20px;
                margin-left: 100px;
                margin-top: 100px;
            }


            .button {
                background-color: #4CAF50;  /* Green */
                border: 2px;
                border-radius: 2px;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                transition-duration: 0.4s;
            }
            .button:hover {
              background-color: white;
              color: #4CAF50;  /* Green */
            }
            .button2 {background-color: #4CAF50;} /* Green */
        </style>
    </head>

    <body>
        <div class="background-box">
                <h2>Student Registration</h2>

                <a href="/student/showForm"><button class="button">Register</button></a>
                <a href="/student/displayForm"><button class="button button2">Display</button></a>

        </div>
    </body>
</html>
