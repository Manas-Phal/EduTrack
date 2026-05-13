let chart;
const ctx = document.getElementById("mainChart");

function showChart(type){

    if(chart){
        chart.destroy();
    }

    if(type==="pie"){

        chart = new Chart(ctx,{
            type:"pie",
            data:{
                labels:courseLabels,
                datasets:[{
                    data:courseData
                }]
            },
            options:{
                responsive:true,
                maintainAspectRatio:false
            }
        });
    }

    else if(type==="bar"){

        chart = new Chart(ctx,{
            type:"bar",
            data:{
                labels:courseLabels,
                datasets:[{
                    label:"Students",
                    data:courseData
                }]
            },
            options:{
                responsive:true,
                maintainAspectRatio:false
            }
        });
    }

    else{

        chart = new Chart(ctx,{
            type:"doughnut",
            data:{
                labels:["Paid","Pending"],
                datasets:[{
                    data:[paid,pending]
                }]
            },
            options:{
                responsive:true,
                maintainAspectRatio:false
            }
        });
    }
}

showChart("pie");