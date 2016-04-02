<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Cha·快递</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<meta name="description" content="稳定可靠的微信服务" />
<meta name="keywords"
	content="dassmeta, nayun, nayun.info, nayun, 拿云, 拿云信息" />
<meta name="author" content="nayun.info" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="shortcut icon" href="favicon.ico">
<link rel="stylesheet"
	href="//g.alicdn.com/sui-mobile/sm/0.5.0/css/sm.min.css">
<link rel="stylesheet"
	href="//g.alicdn.com/sui-mobile/sm/0.5.0/css/sm-extend.min.css">
</head>
<body class="theme-green">
	<div class="page">
		<div class="content">
			<div class="list-block">
				<ul>
					<li>
						<div class="item-content">
							<div class="item-media">
								<i class="icon icon-code"></i>
							</div>
							<div class="item-inner">
								<div class="item-title label">单号：</div>
								<div class="item-input">
									<input type="text" id="postid" placeholder="快递单号" />
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="item-content">
							<div class="item-media">
								<i class="icon icon icon-home"></i>
							</div>
							<div class="item-inner">
								<div class="item-title label">公司：</div>
								<div class="item-input">
									<input type="text" id="express-company" placeholder="快递公司" />
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="content-block">
				<div class="row">
					<div class="col-25">&nbsp;</div>
					<div class="col-50">
						<a href="#" class="button button-big button-success"
							id="btn_query_express">查询</a>
					</div>
					<div class="col-25">&nbsp;</div>
				</div>
			</div>
		</div>
	</div>

	<script type='text/javascript'
		src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/sui-mobile/sm/0.5.0/js/sm.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/sui-mobile/sm/0.5.0/js/sm-extend.min.js'
		charset='utf-8'></script>

	<script>
		$("#express-company")
				.picker(
						{
							toolbarTemplate : '<header class="bar bar-nav">\
  <button class="button button-link pull-left">按钮</button>\
  <button class="button button-link pull-right close-picker">确定</button>\
  <h1 class="title">标题</h1>\
  </header>',
							cols : [ {
								textAlign : 'center',
								values : [ 'EMS', '申通', '圆通', '中通', '汇通',
										'E邮宝', 'UPS', '顺丰', '韵达', '天天', '宅急送',
										'邮政包裹', 'AAE', '安信达', 'BHT', '百福东方',
										'包裹/平邮/挂号信', 'COE', 'CCES（希伊艾斯）',
										'DHL', '大田', '德邦', 'D速', '递四方', '飞康达',
										'FedEx（国际）', '凡客', '能达速递', '挂号信',
										'共速达', '京广', '佳吉', '佳怡', '急先达', '龙邦',
										'联昊通', '联邦快递（国内）', '全一', '全晨', '全日通',
										'全峰', '速尔', '盛辉', '申通E物流', '穗佳物流',
										'TNT', '天地华宇', '特快专递', '新邦', '信丰',
										'鑫飞鸿', '星晨急便', '优速', '运通', '源伟丰', '远成',
										'越丰', '亚风', '元智捷诚', '邮政国内包裹', '邮政国际包裹',
										'中铁快运', '中邮物流' ]
							} ]
						});

		$("#btn_query_express").on("click", function() {
			var typeKey = $("#express-company").val();
			var postid = $("#postid").val();
			$.ajax({
				type : 'POST',
				url : '/express',
				data : {
					typeKey : typeKey,
					postid : postid
				},
				dataType : 'json',
				timeout : 3000,
				success : function(data) {

				},
				error : function(xhr, type) {
					alert('Ajax error!')
				}
			})
		});
	</script>
</body>
</html>