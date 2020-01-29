["^ ","~:resource-id",["~:shadow.build.classpath/resource","goog/debug/error.js"],"~:js","goog.provide(\"goog.debug.Error\");\n/**\n * @constructor\n * @extends {Error}\n * @param {*=} opt_msg\n */\ngoog.debug.Error = function(opt_msg) {\n  if (Error.captureStackTrace) {\n    Error.captureStackTrace(this, goog.debug.Error);\n  } else {\n    var stack = (new Error).stack;\n    if (stack) {\n      /** @override */ this.stack = stack;\n    }\n  }\n  if (opt_msg) {\n    /** @override */ this.message = String(opt_msg);\n  }\n  /** @type {boolean} */ this.reportErrorToServer = true;\n};\ngoog.inherits(goog.debug.Error, Error);\n/** @override */ goog.debug.Error.prototype.name = \"CustomError\";\n","~:source","// Copyright 2009 The Closure Library Authors. All Rights Reserved.\n//\n// Licensed under the Apache License, Version 2.0 (the \"License\");\n// you may not use this file except in compliance with the License.\n// You may obtain a copy of the License at\n//\n//      http://www.apache.org/licenses/LICENSE-2.0\n//\n// Unless required by applicable law or agreed to in writing, software\n// distributed under the License is distributed on an \"AS-IS\" BASIS,\n// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n// See the License for the specific language governing permissions and\n// limitations under the License.\n\n/**\n * @fileoverview Provides a base class for custom Error objects such that the\n * stack is correctly maintained.\n *\n * You should never need to throw goog.debug.Error(msg) directly, Error(msg) is\n * sufficient.\n *\n */\n\ngoog.provide('goog.debug.Error');\n\n\n\n/**\n * Base class for custom error objects.\n * @param {*=} opt_msg The message associated with the error.\n * @constructor\n * @extends {Error}\n */\ngoog.debug.Error = function(opt_msg) {\n\n  // Attempt to ensure there is a stack trace.\n  if (Error.captureStackTrace) {\n    Error.captureStackTrace(this, goog.debug.Error);\n  } else {\n    var stack = new Error().stack;\n    if (stack) {\n      /** @override */\n      this.stack = stack;\n    }\n  }\n\n  if (opt_msg) {\n    /** @override */\n    this.message = String(opt_msg);\n  }\n\n  /**\n   * Whether to report this error to the server. Setting this to false will\n   * cause the error reporter to not report the error back to the server,\n   * which can be useful if the client knows that the error has already been\n   * logged on the server.\n   * @type {boolean}\n   */\n  this.reportErrorToServer = true;\n};\ngoog.inherits(goog.debug.Error, Error);\n\n\n/** @override */\ngoog.debug.Error.prototype.name = 'CustomError';\n","~:compiled-at",1580318684525,"~:source-map-json","{\n\"version\":3,\n\"file\":\"goog.debug.error.js\",\n\"lineCount\":23,\n\"mappings\":\"AAuBAA,IAAAC,QAAA,CAAa,kBAAb,CAAA;AAUA;;;;;AAAAD,IAAAE,MAAAC,MAAA,GAAmBC,QAAQ,CAACC,OAAD,CAAU;AAGnC,MAAIF,KAAAG,kBAAJ;AACEH,SAAAG,kBAAA,CAAwB,IAAxB,EAA8BN,IAAAE,MAAAC,MAA9B,CAAA;AADF,QAEO;AACL,QAAII,QAAQA,CAAA,IAAIJ,KAAJI,OAAZ;AACA,QAAIA,KAAJ;AAEE,uBAAA,IAAAA,MAAA,GAAaA,KAAb;AAFF;AAFK;AAQP,MAAIF,OAAJ;AAEE,qBAAA,IAAAG,QAAA,GAAeC,MAAA,CAAOJ,OAAP,CAAf;AAFF;AAYA,yBAAA,IAAAK,oBAAA,GAA2B,IAA3B;AAzBmC,CAArC;AA2BAV,IAAAW,SAAA,CAAcX,IAAAE,MAAAC,MAAd,EAAgCA,KAAhC,CAAA;AAIA,iBAAAH,IAAAE,MAAAC,MAAAS,UAAAC,KAAA,GAAkC,aAAlC;;\",\n\"sources\":[\"goog/debug/error.js\"],\n\"sourcesContent\":[\"// Copyright 2009 The Closure Library Authors. All Rights Reserved.\\n//\\n// Licensed under the Apache License, Version 2.0 (the \\\"License\\\");\\n// you may not use this file except in compliance with the License.\\n// You may obtain a copy of the License at\\n//\\n//      http://www.apache.org/licenses/LICENSE-2.0\\n//\\n// Unless required by applicable law or agreed to in writing, software\\n// distributed under the License is distributed on an \\\"AS-IS\\\" BASIS,\\n// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\\n// See the License for the specific language governing permissions and\\n// limitations under the License.\\n\\n/**\\n * @fileoverview Provides a base class for custom Error objects such that the\\n * stack is correctly maintained.\\n *\\n * You should never need to throw goog.debug.Error(msg) directly, Error(msg) is\\n * sufficient.\\n *\\n */\\n\\ngoog.provide('goog.debug.Error');\\n\\n\\n\\n/**\\n * Base class for custom error objects.\\n * @param {*=} opt_msg The message associated with the error.\\n * @constructor\\n * @extends {Error}\\n */\\ngoog.debug.Error = function(opt_msg) {\\n\\n  // Attempt to ensure there is a stack trace.\\n  if (Error.captureStackTrace) {\\n    Error.captureStackTrace(this, goog.debug.Error);\\n  } else {\\n    var stack = new Error().stack;\\n    if (stack) {\\n      /** @override */\\n      this.stack = stack;\\n    }\\n  }\\n\\n  if (opt_msg) {\\n    /** @override */\\n    this.message = String(opt_msg);\\n  }\\n\\n  /**\\n   * Whether to report this error to the server. Setting this to false will\\n   * cause the error reporter to not report the error back to the server,\\n   * which can be useful if the client knows that the error has already been\\n   * logged on the server.\\n   * @type {boolean}\\n   */\\n  this.reportErrorToServer = true;\\n};\\ngoog.inherits(goog.debug.Error, Error);\\n\\n\\n/** @override */\\ngoog.debug.Error.prototype.name = 'CustomError';\\n\"],\n\"names\":[\"goog\",\"provide\",\"debug\",\"Error\",\"goog.debug.Error\",\"opt_msg\",\"captureStackTrace\",\"stack\",\"message\",\"String\",\"reportErrorToServer\",\"inherits\",\"prototype\",\"name\"]\n}\n"]