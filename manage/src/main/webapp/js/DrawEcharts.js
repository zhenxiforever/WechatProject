/**
 * 
 * 画曲线图
 * @author 2014/05/02 zeng zhihui
 *         
 */

/**
 * 画曲线图
 * 
 * @param {string} container 模块标识id
 * @param {Array.<string>} yInfosArray 图表Y轴数据
 * @param {Array.<string>} xInfosArray 图表Y轴数据
 */
function drawEcharts(container, yInfosArray, xInfosArray) {
	// 路径配置
	require.config({
		paths : {
			'echarts' : '../js/echarts',
			'echarts/chart/line' : '../js/echarts'
		}
	});

	// 使用
	require(
			[ 'echarts', 'echarts/chart/line' // 按需加载
			],
			function(ec) {
				// 基于准备好的dom，初始化echarts图表
				var myChart = ec.init(container);

				option = {
				    tooltip : {
                        trigger: 'axis'
                    },
					calculable : false,
					grid : {
                                x: 34, //图表左上角坐标X轴
                                y: 6, //图表左上角坐标Y轴
                                width: 510, //图表宽
                                height: 222 //图表高
                               },
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data :xInfosArray // 日期
					} ],
					yAxis : [ {
						type : 'value',
						splitArea : {
							show : true
						}
					} ],
					series : [ {
						name : '人数',
						type : 'line',
						stack : '',
						symbol : 'none',
						smooth : false,
						data : yInfosArray // 人数
					} ]
				};

				// 为echarts对象加载数据
				myChart.setOption(option);
			});
}